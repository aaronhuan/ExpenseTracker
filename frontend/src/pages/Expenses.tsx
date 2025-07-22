import Navbar from "../components/Navbar";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";

const StyledBody=styled.main`
    display:flex;
    padding:2vw;
    background:lightblue;
    height:100vh;
`;


export default function Expenses(){
    return(
        <>
            <Navbar/>
            <StyledBody>
                <Sidebar/>
                <p>hi</p>
            </StyledBody>
        </>
    )
}