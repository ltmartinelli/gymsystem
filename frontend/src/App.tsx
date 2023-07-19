import { Router } from 'react-router'
import './index.css'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import ClientHome from './routes/Client/ClientHome'
import HomePage from './routes/Client/ClientHome/HomePage'

function App()
{

  return (
    <>
      <BrowserRouter>
        <Routes>
        <Route path='/' element={<ClientHome/>}>
          <Route index element={<HomePage/>}/>
        </Route>

        <Route path="*" element={<Navigate to="/" />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
