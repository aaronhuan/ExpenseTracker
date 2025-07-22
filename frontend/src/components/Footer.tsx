import styled from "styled-components";
import { Link } from "react-router-dom"

const StyledDiv = styled.div`
    display: flex;
    justify-content: space-between;
    padding: 0 2vw;
`;

const StyledContentContainer = styled.div`
    display:flex;
    flex-direction: column;
`;


export default function Footer(){
    return(
        // <StyleP>All rights reserved by Aaron Huang <Link to="">Credits</Link> &#169; </StyleP>
        <StyledDiv>

            <StyledContentContainer>
                <p>Link list</p>
                <a>Privacy Policy/Terms</a>
            </StyledContentContainer>

            <StyledContentContainer>
                <p>©2025 Aaron Huang. All rights reserved.</p>
                <a href="https://github.com/aaronhuan/ExpenseTracker/tree/main">view the code on Github</a>
            </StyledContentContainer>

        </StyledDiv>
    ); 
}