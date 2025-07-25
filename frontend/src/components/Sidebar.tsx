import styled from "styled-components";
import { Image } from "react-bootstrap";
import { Link } from "react-router-dom";

const StyedColumn = styled.div`
    display:flex;
    padding:100px;
    flex-direction: column;
    margin:0+10px+0+0px;
    background:white;
`;

const StyledUser= styled.div`
    display:flex;
    gap:10px;
    justify-content:center;
    align-items:center;
`;

const StyledUL = styled.ul`
    display:flex;
    justify-content: space-evenly;
    flex-direction:column;
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

export default function Sidebar(){
    return(
        <StyedColumn>
            <StyledUser>
                <Image roundedCircle
                src="/financebg.png"
                width={80}
                height={80}
                style={{ boxShadow: '0 2px 8px rgba(0,0,0,0.1)', padding: '4px' }}
                />
                <p>user</p>
            </StyledUser>
            <StyledUL>
                <StyledLI><StyledLink to={'/'}>Dashboard</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/login'}>Transactions</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/signup'}>Incomes</StyledLink></StyledLI>
                <StyledLI><StyledLink to={'/expenses'}>Expenses</StyledLink></StyledLI>
            </StyledUL>
        </StyedColumn>
    );
}