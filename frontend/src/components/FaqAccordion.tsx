import { Accordion } from "react-bootstrap";
import styled from "styled-components";

const FAQWrapper= styled.section`
    margin: 0 auto;
    padding: 2vw 1.5vw;
`;
const Styledtitle = styled.h2`
    text-align:left;
`;

export default function FaqAccordion(){
    let data = [
        {
        question: "question1",
        answer: "Lorem ipsom dolor sit amit, consector"
        },
        
        {
        question: "question1",
        answer: "Lorem ipsom dolor sit amit, consector"
        },
        
        {
        question: "question1",
        answer: "Lorem ipsom dolor sit amit, consector"
        },
    ]
    
    return(
        <FAQWrapper>
            <hr/>
            <Styledtitle>FAQ</Styledtitle>
            {
                data.map((item)=> (
                    <Accordion>
                        <Accordion.Header>
                            {item.question}
                        </Accordion.Header>
                        <Accordion.Body>
                            {item.answer}
                        </Accordion.Body>
                    </Accordion>
                )
                )
            }
            <hr/>
        </FAQWrapper>
    )
}