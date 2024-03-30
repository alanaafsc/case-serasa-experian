import React, { useState } from 'react';
import styles from './Ordenar.module.css'; 
import { ReactComponent as AngleDownIcon } from './angle-down.svg'; // Importar o SVG como um componente React

// const Ordenar: React.FC = () => {
//   return (
//     <button className={styles.button}>
//       Ordenar por 
//       <AngleDownIcon className={styles.icon} />
//     </button>
//   );
// };

// export default Ordenar;

const Ordenar: React.FC<{ onOrdenacaoChange: (ordenacao: 'asc' | 'desc') => void }> = ({ onOrdenacaoChange }) => {
  const [menuAberto, setMenuAberto] = useState(false);

  const toggleMenu = () => {
    setMenuAberto(!menuAberto);
  };

  const handleOrdenacao = (ordenacao: 'asc' | 'desc') => {
    onOrdenacaoChange(ordenacao);
    setMenuAberto(false);
  };

  return (
    <div className={styles.container}>
      <button className={styles.button} onClick={toggleMenu}>
        Ordenar por
        <AngleDownIcon className={styles.icon} />
      </button>
      {menuAberto && (
        <div className={styles.menu}>
          <div className={styles.menuItem} onClick={() => handleOrdenacao('asc')}>
            Ascendente
          </div>
          <div className={styles.menuItem} onClick={() => handleOrdenacao('desc')}>
            Descendente
          </div>
        </div>
      )}
    </div>
  );
};

export default Ordenar;
