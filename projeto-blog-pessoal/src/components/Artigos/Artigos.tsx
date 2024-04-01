import React, { useState, useEffect } from 'react';
import styles from './Artigos.module.css';
import Divider from './Divider';
import Article from './Article';
import { format } from 'date-fns'; 

type ArticleType = {
    title: string;
    content: string;
    author: string;
    publicationDate: string;
};

const Artigos: React.FC<{ autoresSelecionados: string[]; ordenacao: 'asc' | 'desc' | null }> = ({ autoresSelecionados, ordenacao }) => {

    const [articles, setArticles] = useState<ArticleType[]>([]);

    useEffect(() => {
        console.log(ordenacao);
        const autoresQuery = autoresSelecionados.map(autor => `autores=${encodeURIComponent(autor)}`).join('&');
        const url = autoresSelecionados.length > 0 ? `http://localhost:8080/v1/artigos/autores?${autoresQuery}` : 'http://localhost:8080/v1/artigos';
    
        fetch(url)
          .then(response => response.json())
          .then((data: any[]) => {
            let sortedArticles = data.map((article: any) => ({
              ...article,
              publicationDate: format(new Date(article.publicationDate), 'dd/MM/yyyy'), // Formatando a data antes de renderizar
            }));
    
            if (ordenacao) {
                sortedArticles = sortedArticles.sort((a, b) => {
                    const formattedDateA = a.publicationDate.includes('/')
                        ? a.publicationDate.split('/').reverse().join('/')
                        : a.publicationDate;
                    const formattedDateB = b.publicationDate.includes('/')
                        ? b.publicationDate.split('/').reverse().join('/')
                        : b.publicationDate;
            
                    const dateA = new Date(formattedDateA);
                    const dateB = new Date(formattedDateB);
            
                    console.log('Data A (antes):', a.publicationDate, 'Data B (antes):', b.publicationDate);
                    console.log('Data A (depois):', dateA, 'Data B (depois):', dateB);
            
                    let comparisonResult = 0;
                    if (ordenacao === 'asc') {
                        comparisonResult = dateA.getTime() - dateB.getTime();
                    } else {
                        comparisonResult = dateB.getTime() - dateA.getTime();
                    }
            
                    console.log('Resultado da comparação:', comparisonResult);
            
                    return comparisonResult;
                });
            }
            
            console.log(sortedArticles)
            setArticles(sortedArticles);
          })
          .catch(error => console.error('Error fetching articles:', error));
      }, [autoresSelecionados, ordenacao]);
    
    
    
    return (
        <div className={styles.artigos}>
            <Divider />
            {articles.map((article, index) => (
                <React.Fragment key={index}>
                    <Article article={article} />
                    {index !== articles.length - 1 && <Divider />}
                </React.Fragment>
            ))}
        </div>
    );
};

export default Artigos;
