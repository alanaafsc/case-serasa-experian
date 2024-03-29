import React from 'react';
import styles from './LastNews.module.css';
import { format } from 'date-fns';

type Article = {
    title: string;
    publicationDate: string;
};

type LastNewsProps = {
    article: Article;
};

const LastNews: React.FC<LastNewsProps> = ({ article }) => {
    const { title, publicationDate } = article;

    const formatDate = (dateString: string): string => {
        const date = new Date(dateString);
        return format(date, 'dd/MM/yyyy');
    };

    return (
        <div className={styles.lastNews}>
            <div className={styles.titleNew}>{title}</div>
            <div className={styles.dateNew}>{formatDate(publicationDate)}</div>
        </div>
    );
};

export default LastNews;