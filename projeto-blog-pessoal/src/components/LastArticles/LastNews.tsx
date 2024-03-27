import React from 'react';
import styles from './LastNews.module.css';

const LastNews: React.FC = () => {
    return (
        <div className={styles.lastNews}>
            <div className={styles.titleNew}>Título do Artigo </div>
            <div className={styles.dateNew}>30/03/2000</div>
        </div>
    );
};

export default LastNews;