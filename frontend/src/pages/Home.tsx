
import FaqAccordion from "../components/FaqAccordion";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styled from "styled-components";
import TestimonialCarousel from "../components/TestimonialCarousel";

const StyledBanner = styled.div`
    display:flex;
    flex-direction: column;
    align-items: center;
    justify-content:center;
    // background: url("/public/financebg.jpg");
    // background-size: cover;
    // background-position: center;
    height: 400px; 
`;
export default function Home(){
    return(
    <>
    {/*<header/>*/}
    <Navbar/>
    {/* <main title banner/> */}
    <StyledBanner>
        <h1>Expense Tracker</h1>
        <button>get started</button>

    </StyledBanner>

    {/* <testimonials/> 
     carasoul effect
    
    */}
    <TestimonialCarousel/>

    {/* <faq/> 
    collapsible accordion FAQ
    */}
    <FaqAccordion/>

    {/* <footer/> */}
    <Footer/>
    </>
    )
}