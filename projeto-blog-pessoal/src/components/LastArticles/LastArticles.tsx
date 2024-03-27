import React from 'react';
import styles from './LastArticles.module.css';

const LastArticles: React.FC = () => {
    return (
        <div className={styles.lastArticles}>
            <div className={styles.title}>Título do Artigo</div>
        </div>
    );
};

export default LastArticles;