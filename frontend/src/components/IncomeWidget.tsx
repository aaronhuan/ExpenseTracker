import styled from "styled-components";
const Widget=styled.div`
    background:white;
    border-radius:0.5rem;
    padding:1rem;
    display:flex;
    flex-direction:column;

`;

const Row= styled.div`
    display:flex;
    justify-content:space-between;
`;

const Pay = styled.div`
    gap:0.3rem;
    display:flex
`

export default function IncomeWidget(){
    return(
        <Widget>
            <Row>
                <p>Source</p>
                <p>date</p>
            </Row>
            <Pay>
                <p>(Frequency) pay of</p>
                <p>$Amount</p>
            </Pay>
            <p>--Notes</p>
        </Widget>
    );
}