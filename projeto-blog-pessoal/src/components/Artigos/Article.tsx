import React, { useState, useEffect } from 'react';
import styles from './Article.module.css';
import IconLinkedin from './linkedin-icon.svg';
import IconTwitter from './twitter-icon.svg';
import IconLink from './link-icon.svg';

type ArticleProps = {
    article: {
        title: string;
        content: string;
        author: string;
        publicationDate: string;
    };
};

const Article: React.FC<ArticleProps> = ({ article }) => {
    const { title, content, author, publicationDate } = article;

    return (
        <div className={styles.article}>
            <div className={styles.authorDateIcon}>
                {/* Autor, Data e Ícones */}
                <div className={styles.authorDate}>
                    <div className={styles.author}>{author}</div>
                    <div className={styles.date}>{publicationDate}</div>
                </div>
                <div className={styles.icons}>
                    <button>
                        <img src={IconTwitter} alt="Ícone do Twitter" />
                    </button>
                    <button>
                        <img src={IconLinkedin} alt="Ícone do LinkedIn" />
                    </button>
                    <button>
                        <img src={IconLink} alt="Ícone de Link" />
                    </button>
                </div>
            </div>
            <div className={styles.content}>
                {/* Conteúdo do artigo */}
                <div className={styles.title}>{title}</div>
                <div className={styles.text}>{content}</div>
            </div>
        </div>
    );
};

export default Article;

