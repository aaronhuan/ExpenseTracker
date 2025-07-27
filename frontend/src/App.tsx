import { useEffect } from "react";
import Home from "./pages/Home";
import { createBrowserRouter, Route, Routes, RouterProvider, useLocation} from "react-router-dom";
import Login from "./pages/Login";
import Expenses from "./pages/Expenses";
import Signup from "./pages/Signup";
import Dashboard from "./pages/Dashboard";
import Transactions from "./pages/Transactions";
import Incomes from "./pages/Incomes";

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
        <Route path={'dashboard'} element={<Dashboard/>}/>
        <Route path={'/expenses'} element={<Expenses/>}/>
        <Route path={'/incomes'} element={<Incomes/>}/>
        <Route path={'/transactions'} element= {<Transactions/>}/>
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

