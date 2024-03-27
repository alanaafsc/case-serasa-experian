// App.tsx
import React from 'react';
import HeaderNews from './components/HeaderNews/HeaderNews';
import Artigos from './components/Artigos/Artigos';
import FiltrarPorAutor from './components/FiltrarPorAutor/FiltrarPorAutor';
import Ordenar from './components/Ordenar/Ordenar';
import LastArticles from './components/LastArticles/LastArticles';
import Footer from './components/Footer/Footer';

const App: React.FC = () => {
  return (
    <div>
      <HeaderNews />
      <FiltrarPorAutor />    
      <Ordenar />  
      <Artigos />
      <LastArticles />
      <Footer />
    </div>
  );
};

export default App;

