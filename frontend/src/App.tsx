import { useEffect } from "react";
import Home from "./pages/Home";
import { createBrowserRouter, Route, Routes, RouterProvider, useLocation} from "react-router-dom";
import Login from "./pages/Login";
import Expenses from "./pages/Expenses";
import Categories from "./pages/Categories";
import Signup from "./pages/Signup";

function Root(){
  const location = useLocation();
  const editedpath=location.pathname.slice(1); // remove /
  useEffect(()=>{
    if(editedpath ===""){
      document.title="Home";
    }else{
      document.title=editedpath.charAt(0).toUpperCase() + editedpath.slice(1);
    }
  },[editedpath])
  return(
    <>
      <Routes>
        <Route path={'/*'} element = {<Home/>}/>
        <Route path={'/login'} element = {<Login/>}/>
        <Route path={'/signup'} element = {<Signup/>}/>
        <Route path={'/expenses'} element={<Expenses/>}/>
        <Route path={'/categories'} element= {<Categories/>}/>
        {/* Route... */}
      </Routes>
    </>
  )
}

const router = createBrowserRouter([
  {path: "*", element: <Root/>}
]);

export default function App() {
  return <RouterProvider router = {router}/>
}

