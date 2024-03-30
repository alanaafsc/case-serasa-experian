import React, { useState, useEffect, useRef } from 'react';
import styles from './FiltrarPorAutor.module.css'; 
import { ReactComponent as AngleDownIcon } from './angle-down.svg'; // Importar o SVG como um componente React

const FiltrarPorAutor: React.FC<{ onAutoresSelecionados: (autores: string[]) => void }> = ({ onAutoresSelecionados }) => {
  const [autores, setAutores] = useState<{ nome: string; selecionado: boolean }[]>([]);
  const [menuAberto, setMenuAberto] = useState(false);
  const menuRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    fetch('http://localhost:8080/v1/artigos')
      .then(response => response.json())
      .then((data: any[]) => {
        // Extrair autores únicos dos artigos
        const autoresUnicos = Array.from(new Set(data.map((artigo: any) => artigo.author)));
        // Criar a lista de autores com a estrutura { nome: string, selecionado: boolean }
        const autoresFormatados = autoresUnicos.map(nome => ({ nome: String(nome), selecionado: false }));
        // Atualizar o estado com a lista de autores
        setAutores(autoresFormatados);
        // Atualizar os artigos quando nenhum autor estiver selecionado
        onAutoresSelecionados([]);
      })
      .catch(error => console.error('Error fetching authors:', error));
  
    function handleClickOutside(event: MouseEvent) {
      if (menuRef.current && !menuRef.current.contains(event.target as Node)) {
        setMenuAberto(false);
      }
    }
  
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const handleAutorSelecionado = (autor: string) => {
    const autoresAtualizados = autores.map(a => {
      if (a.nome === autor) {
        return { ...a, selecionado: !a.selecionado };
      }
      return a;
    });
    setAutores(autoresAtualizados);
    // Atualizar os artigos quando um autor é selecionado ou desselecionado
    const autoresSelecionados = autoresAtualizados.filter(a => a.selecionado).map(a => a.nome);
    onAutoresSelecionados(autoresSelecionados);
  };

  const toggleMenu = () => {
    setMenuAberto(!menuAberto);
  };

  const filtrarAutoresSelecionados = () => {
    const autoresSelecionados = autores.filter(a => a.selecionado).map(a => a.nome);
    onAutoresSelecionados(autoresSelecionados);
    setMenuAberto(false);
  };

  return (
    <div className={styles.container}>
      <button className={styles.button} onClick={toggleMenu}>
        Filtrar por autor
        <AngleDownIcon className={styles.icon} />
      </button>
      {menuAberto && (
        <div ref={menuRef} className={styles.menu}>
          {autores.map((autor, index) => (
            <div key={index} className={styles.menuItem} onClick={() => handleAutorSelecionado(autor.nome)}>
              <label>
                <input type="checkbox" checked={autor.selecionado} readOnly onChange={() => {}} />
                {autor.nome}
              </label>
            </div>
          ))}
          <button className={styles.filtrarButton} onClick={filtrarAutoresSelecionados}>
            Filtrar
          </button>
        </div>
      )}
    </div>
  );
};

export default FiltrarPorAutor;

