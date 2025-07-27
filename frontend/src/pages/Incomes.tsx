import styled from "styled-components";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import Footer from "../components/Footer";

const Main = styled.main`
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 2rem;
    overflow: auto;
`;

const Page = styled.div`
    display: flex;
    height: 100vh;
    background: #e0f2fe;
`;

const AddWrapper = styled.div`
`;

const IncomeWrapper= styled.div`
`;

const IncomeWidget=styled.div`
`;
export default function Incomes(){
    return(
        <>
            <Navbar />
            <Page>
                <Sidebar/>
                <AddWrapper>
                    <p>source</p>
                    {/* <input>Source</input> */}
                    {/* <input>Amount</input> */}
                    {/* Date, optional, today's date unless specified */}
                    {/* Note optional. "" unless specified */}
                    {/* yes or no reoccuring
                    if so how often */}
                    {/* button to add the income */}
                </AddWrapper>
                <IncomeWrapper>
                    <h1>Total Income: ___</h1>
                    <IncomeWidget></IncomeWidget>
                </IncomeWrapper>
            </Page>
            <Footer/>
        </>
    )
}