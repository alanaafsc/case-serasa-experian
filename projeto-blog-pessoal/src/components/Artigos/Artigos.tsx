import React from 'react';
import styles from './Artigos.module.css';
import Divider from './Divider';
import Article from './Article';

const Artigos: React.FC = () => {
    return (
        <div className={styles.artigos}>
            <Divider />
            <Article />
            <Divider />
            <Article />
            <Divider />
        </div>
    );
};

export default Artigos;
