import styled from "styled-components";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

const Styledmain=styled.main`
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    height: 60vh;
    margin:10vh + 30vw;
    background: lightblue;
    border-radius:10px;
`;

const Styledform= styled.form`
    display:flex;
    flex-direction:column;
    align-items:center;
`
export default function Login(){
    return(
        <>
            <Navbar/>
            <Styledmain>
                <h3>Login in</h3>
                <Styledform>
                    <label>Email</label>
                    <input type="email" placeholder="Enter your email" required/>

                    <label>Password</label>
                    <input type="password" placeholder="Enter your password" required/>
                    <p>Forgot password?</p>
                    <button>Submit</button>
                </Styledform>
                <p>Don't have an account? signup</p>
            </Styledmain>
            <Footer/> 
        </>
    )
}