import logo from './logo.svg';
import './App.css';
import Header from './components/header/header';
import { BrowserRouter, Outlet } from 'react-router-dom';
import PostRoutes from './routes';
import { useEffect, useState } from 'react';

function App() {

  
    return <div className="App">
      
        <BrowserRouter>
          <Header></Header>
          <PostRoutes></PostRoutes>
        </BrowserRouter>
    </div>
}

export default App;
