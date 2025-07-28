import styled from "styled-components";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import Footer from "../components/Footer";
import IncomeWidget from "../components/IncomeWidget";

const Page = styled.div`
    display: flex;
    background: #e0f2fe;
    overflow: hidden;
`;

const Main = styled.main`
    flex: 1;
    display: flex;
    padding: 2rem;
    overflow: auto;
    gap:1rem;
    padding:2rem;
`;

const AddWrapper = styled.div`
    flex:1;
    background:white;
    padding:1.5rem;
    border-radius: 0.5rem;
    display:flex;
    flex-direction: column;
    height:fit-content;
`;

const Input = styled.input`
    padding:1rem;
    border-radius: 0.5rem;
`;

const Label = styled.label`
`;

const Select = styled.select`
    padding: 0.75rem;
    border: 1px solid #cbd5e1;
    border-radius: 0.375rem;
    font-size: 1rem;
    width: 100%;
    background: white;
`;

const Button= styled.button`
    background:lightgreen;
    border-radius:0.5rem;
`;

const IncomeWrapper= styled.div`
    flex:2;
    display:flex;
    flex-direction: column;
    gap:1rem;
`;

const IncomeLabelWrapper= styled.h3`
    text-align:center;
`;


export default function Incomes(){

    return(
        <>
            <Navbar />
            <Page>
                <Sidebar/>
                <Main>
                    <AddWrapper>
                    <Label>Source</Label>
                    <Input
                        placeholder="e.g. Clerk"
                    />

                    <Label>Amount</Label>
                    <Input
                        type="number"
                        min="0"
                        step="0.01"
                        placeholder="0.00"
                    />

                    <Label>Date</Label>
                    <Input
                        type="date"
                    />

                    <Label>Frequency</Label>
                        <Select>
                            <option>One-time</option>
                            <option>Weekly</option>
                            <option>Biweekly</option>
                            <option>Monthly</option>
                            <option>Yearly</option>
                        </Select>

                    <Label>Note (Optional)</Label>
                    <Input
                        placeholder="Additional notes"
                    />
                </AddWrapper>
                <IncomeWrapper>
                    <IncomeLabelWrapper>Total Income: $___</IncomeLabelWrapper>
                    <IncomeWidget/>
                    <IncomeWidget/>
                    <IncomeWidget/>
                    <IncomeWidget/>
                    <IncomeWidget/>
                </IncomeWrapper>
                </Main>
            </Page>
            <Footer/>
        </>
    )
}
