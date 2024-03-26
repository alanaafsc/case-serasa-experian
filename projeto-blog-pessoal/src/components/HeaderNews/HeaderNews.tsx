import React from 'react';
import styles from './HeaderNews.module.css';
import GroupSVG from './logo-allowme-news.svg';

const HeaderNews: React.FC = () => {
    return (
        <header className={styles.header}>
            <div className={styles.rectangle}></div>
            <div className={styles.logo}>
                <img src={GroupSVG} alt="Logo" />
            </div>
        </header>
    );
};

export default HeaderNews;
