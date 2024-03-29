import React, { useState, useEffect } from 'react';
import styles from './LastArticles.module.css';
import LastNews from './LastNews';

type Article = {
    title: string;
    publicationDate: string;
};

const LastArticles: React.FC = () => {
    const [articles, setArticles] = useState<Article[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/v1/artigos/recentes')
            .then(response => response.json())
            .then(data => {
                // Pegar apenas as 4 primeiras notícias
                const firstFourArticles = data.slice(0, 4);
                setArticles(firstFourArticles);
            })
            .catch(error => console.error('Error fetching articles:', error));
    }, []);

    return (
        <div className={styles.lastArticles}>
            <div className={styles.title}>Últimas notícias</div>
            {articles.map((article, index) => (
                <LastNews key={index} article={article} />
            ))}
        </div>
    );
};

export default LastArticles;