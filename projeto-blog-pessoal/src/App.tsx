// App.tsx
import React, { useState } from 'react';
import HeaderNews from './components/HeaderNews/HeaderNews';
import Artigos from './components/Artigos/Artigos';
import FiltrarPorAutor from './components/FiltrarPorAutor/FiltrarPorAutor';
import Ordenar from './components/Ordenar/Ordenar';
import LastArticles from './components/LastArticles/LastArticles';
import Footer from './components/Footer/Footer';

const App: React.FC = () => {
  const [autoresSelecionados, setAutoresSelecionados] = useState<string[]>([]);
  const [ordenacao, setOrdenacao] = useState<'asc' | 'desc' | null>(null);

  const handleAutoresSelecionados = (autores: string[]) => {
    setAutoresSelecionados(autores);
  };

  const handleOrdenacaoChange = (ordenacao: 'asc' | 'desc') => {
    setOrdenacao(ordenacao);
  };

  return (
    <div className="App">
      <HeaderNews />
      <main className="main">
        <FiltrarPorAutor onAutoresSelecionados={handleAutoresSelecionados} />    
        <Ordenar onOrdenacaoChange={handleOrdenacaoChange} />
        <div className="content-container">
          <Artigos autoresSelecionados={autoresSelecionados} ordenacao={ordenacao}/>
          <LastArticles />
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default App;

