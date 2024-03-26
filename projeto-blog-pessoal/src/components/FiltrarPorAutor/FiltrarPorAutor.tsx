import React from 'react';
import styles from './FiltrarPorAutor.module.css'; 
import { ReactComponent as AngleDownIcon } from './angle-down.svg'; // Importar o SVG como um componente React

const FiltrarPorAutor: React.FC = () => {
  return (
    <button className={styles.button}>
      Filtrar por autor
      <AngleDownIcon className={styles.icon} />
    </button>
  );
};

export default FiltrarPorAutor;
