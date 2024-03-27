import React from 'react';
import styles from './Footer.module.css';
import LogoFooter from './logo-footer.svg'

const Footer: React.FC = () => {
    return (
        <div className={styles.footer}>
            <img className={styles.icon} src={LogoFooter} alt="Logo" />
            <div className={styles.text}>
            Copyright © 2023 AllowMe News. Todos os direitos reservados
            </div>
        </div>
    );
};

export default Footer;