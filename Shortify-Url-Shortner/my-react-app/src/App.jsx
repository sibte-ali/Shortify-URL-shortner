import About from "./Component/About"
import Home from "./Component/Home"
import AuthPage from "./Component/AuthPage"
import { Route,Routes } from "react-router-dom"

function App() {
  

  return (
    <>
      
      <>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/about" element={<About/>}/>
        <Route path="/Auth" element={<AuthPage/>}/>
        
      </Routes>
        
      </>
    </>
  )
}

export default App
