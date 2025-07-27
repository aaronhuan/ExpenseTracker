import { Link } from "react-router-dom";
import styled from 'styled-components';

const StyledBigDiv = styled.div`
    display: flex;
    justify-content: space-between;
    padding: 0 2vw;
    position:sticky;
    z-index:1000;
    top:5px;
    background-color:#f8fafc;
    color:#334155
`;

const StyledUL = styled.ul`
    display:flex;
    justify-content: space-evenly;
    margin:0;
    list-style-type:none;
    gap: 50px;
`;

const StyledLI = styled.li`
    text-align: center;
    align-content:center;
    text-decoration: none;
`;

const StyledLink = styled(Link)`
    text-decoration: none;
`;

export default function Navbar(){
    return(
        <StyledBigDiv>
            <p>logo</p>
            <StyledUL>
                <StyledLI><StyledLink to={'/'}>Home</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/login'}>login</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/signup'}>Signup</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/dashboard'}>Dashboard</StyledLink></StyledLI>
            </StyledUL>
        </StyledBigDiv>
    );
}