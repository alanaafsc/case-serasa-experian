import React from 'react';
import styles from './Ordenar.module.css'; 
import { ReactComponent as AngleDownIcon } from './angle-down.svg'; // Importar o SVG como um componente React

const Ordenar: React.FC = () => {
  return (
    <button className={styles.button}>
      Ordenar por 
      <AngleDownIcon className={styles.icon} />
    </button>
  );
};

export default Ordenar;