import styled from "styled-components";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { useState } from "react";
import Footer from "../components/Footer";

const Page = styled.div`
    display: flex;
    height: 100vh;
    background: #e0f2fe;
`;

const Main = styled.main`
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 2rem;
    overflow: auto;
`;

const TopSection =styled.div`
    display:flex;
    gap:2rem;
    margin-bottom:2rem;
`;

const GraphContainer=styled.div`
    flex: 3;
    padding: 1rem;
    box-shadow: 0 4px 12px rgba(0,0,0,0.05);
    background: white;
    border-radius: 0.5rem;
`;

const CategoryContainer=styled.div`
    flex:2;
    padding: 2rem;
    box-shadow:0 4px 12px rgba(0,0,0,0.05);
    background: white;
    border-radius:0.5rem;
    display: flex;
    flex-wrap: wrap;
`;

const Chip = styled.div`
background: lightblue;
border-radius:0.5rem;
display:flex;
padding-left:4px;
padding-right:4px;
`;

const HeaderRow = styled.div`
    display: flex;
    align-items: center;
    position: relative;
    margin: 1rem 0;
`;

const Title = styled.h2`
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    margin: 0;
    font-size: 1.25rem;
    font-weight: 600;
`;

const AddButton = styled.button`
    padding: 0.5rem 1.25rem;
    background: #0284c7;
    color: white;
    border: none;
    border-radius: 0.375rem;
    font-size: 1rem;
    cursor: pointer;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    &:hover {
        background: #0369a1;
    }
`;



const TransactionTable = styled.table`
    background:white;
    border-radius:0.5rem;
    width:100%;
    box-shadow: 0 4px 12px rgba(0,0,0,0.05);
    overflow: hidden;
    border-collapse: collapse;
`;

const StyledTH = styled.th`
    text-align: left;
    padding: 0.5rem 1rem;
    font-size: 1rem;
`;

const StyledTHEditDelete = styled.th`
    text-align:left;
    font-size:1rem;
    padding:0.2rem 0.5rem;
`;

const StyledTD = styled.td`
    text-align:left;
    font-size:1rem;
    padding:0.5rem 1rem;
`;

const StyledTR = styled.tr`
    background-color: ${(props)=>(props.index %2 ===0 ? '#ffffff' : '#f0f0f0e6')}; 
`;

export default function Transaction(){
    const [alter, setAlter]= useState(0);
    const categories = ['Groceries','Rent','Utilities'];
    return(
    <>
        <Navbar/>
        <Page>
            <Sidebar/>
            <Main>
                <HeaderRow>
                    <Title>Transactions</Title>
                </HeaderRow>

                <TransactionTable>
                    <tr>
                        <StyledTH>Date</StyledTH>
                        <StyledTH>Category</StyledTH>
                        <StyledTH>Amount</StyledTH>
                        <StyledTH>Description</StyledTH>
                    </tr>
                    <StyledTR>
                        <StyledTD>01/1/1</StyledTD>
                        <StyledTD>Groceries</StyledTD>
                        <StyledTD>$10000</StyledTD>
                        <StyledTD>meat</StyledTD>
                    </StyledTR>
                    <tr>
                        <StyledTD>01/1/1</StyledTD>
                        <StyledTD>Groceries</StyledTD>
                        <StyledTD>$10000</StyledTD>
                        <StyledTD>meat</StyledTD>
                    </tr>
                </TransactionTable>
            </Main>
        </Page>
        <Footer/>
    </>
    )
}