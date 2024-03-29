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

const Artigos: React.FC = () => {
    const [articles, setArticles] = useState<ArticleType[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/v1/artigos')
            .then(response => response.json())
            .then((data: ArticleType[]) => setArticles(data.map((article: ArticleType) => ({ 
                ...article,
                publicationDate: format(new Date(article.publicationDate), 'dd/MM/yyyy') 
            }))))
            .catch(error => console.error('Error fetching articles:', error));
    }, []);

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

