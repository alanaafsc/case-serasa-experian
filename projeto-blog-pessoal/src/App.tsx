// App.tsx
import React from 'react';
import HeaderNews from './components/HeaderNews/HeaderNews';
import Artigos from './components/Artigos/Artigos';
import FiltrarPorAutor from './components/FiltrarPorAutor/FiltrarPorAutor';

const App: React.FC = () => {
  return (
    <div>
      <HeaderNews />
      <FiltrarPorAutor />      
      <Artigos />
    </div>
  );
};

export default App;

