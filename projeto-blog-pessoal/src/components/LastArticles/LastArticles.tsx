import React from 'react';
import styles from './LastArticles.module.css';
import LastNews from './LastNews';

const LastArticles: React.FC = () => {
    return (
        <div className={styles.lastArticles}>
            <div className={styles.title}>Título do Artigo</div>
            <LastNews />
        </div>
    );
};

export default LastArticles;