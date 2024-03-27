import React from 'react';
import styles from './Article.module.css';
import IconLinkedin from './linkedin-icon.svg';
import IconTwitter from './twitter-icon.svg';
import IconLink from './link-icon.svg';

const Article: React.FC = () => {
    return (
        <div className={styles.article}>
            <div className={styles.authorDateIcon}>
                {/* Autor, Data e Ícones */}
                <div className={styles.authorDate}>
                    <div className={styles.author}>AUTOR 1</div>
                    <div className={styles.date}>30/03/2000</div>
                </div>
                <div className={styles.icons}>
                    <img src={IconTwitter} alt="Ícone do Twitter" />
                    <img src={IconLinkedin} alt="Ícone do LinkedIn" />
                    <img src={IconLink} alt="Ícone de Link" />
                </div>
            </div>
            <div className={styles.content}>
                {/* Conteúdo do artigo */}
                <div className={styles.title}>Título do Artigo</div>
                <div className={styles.text}>Conteúdo do Artigo...</div>
            </div>
        </div>
    );
};

export default Article;

