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
    text-decoration: none;
`;

const StyledLink = styled(Link)`
`;

export default function Navbar(){
    return(
        <StyledBigDiv>
            <p>logo</p>
            <StyledUL>
                {/* <StyledLI><StyledLink to={'/'}>links</StyledLink></StyledLI>
                
                need to establish routes in app.tsx*/}
                <StyledLI><p>links</p></StyledLI>
                <StyledLI><p>links</p></StyledLI>
            </StyledUL>
        </StyledBigDiv>
    );
}