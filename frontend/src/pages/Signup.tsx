import styled from "styled-components";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import { useState } from "react";
import { apiService } from "../services/api/api";

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
`;
export default function Signup(){
    const [Submit, setSubmit] = useState(false);//use state to manage form submission
    const [error, setError] = useState("");//use state to manage error
    const [success, setSuccess] = useState(false);//use state to manage success
    const [formData, setFormData] = useState({//use state to manage form data
        name: "",
        email: "",
        password: "",
        confirmPassword: ""
    });


    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value //set the specific field in formData
        }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();// Stops the form from submitting right after


        // Validate passwords match
        if(formData.password !== formData.confirmPassword) {
            alert("Passwords do not match");
            return;
        }

        //API call
        try{
            setSubmit(true);
            setError("");//no error 
            //call API service
            const response = await apiService.users.create({
                name: formData.name,
                email: formData.email,
                password: formData.password
            });
            setSuccess(true); // Set success state

            // Reset form after successful submission
            setFormData({
                name: "",
                email: "",
                password: "",
                confirmPassword: ""
            });
        } catch (e){
            console.error("Error creating user:", e);
            setError(e instanceof Error ? e.message : "Signup failed");
        } finally {
            setSubmit(false); // Reset submitting state
        }


    };

    return(
        <>
            <Navbar/>
            <Styledmain>
                <h3>Sign up</h3>
                {success ? (
                    <div>
                        <p>Sign up successsful!</p>
                    </div>
                ) : (
                    <>
                    <Styledform onSubmit={handleSubmit} method="POST"> {/* Form submission handler + method POST so password and information not shown in URL */}
                    <label>Name</label>
                    <input 
                    type="name"
                    name="name"
                    value={formData.name} 
                    onChange={handleChange}
                    placeholder="Enter your name" 
                    required/>

                    <label>Email</label>
                    <input 
                    type="email"
                    name="email"
                    value={formData.email} 
                    onChange={handleChange}
                    placeholder="Enter your email" 
                    required/>

                    <label>Password</label>
                    <input
                    type="password"
                    name="password"
                    value={formData.password} 
                    onChange={handleChange}
                    placeholder="Create a password" 
                    required/>

                    <label>Confirm Password</label>
                    <input 
                    type="password"
                    name="confirmPassword"
                    value={formData.confirmPassword} 
                    onChange={handleChange}
                    placeholder="Confirm your password"
                    required/>
                    <button>{Submit ? "Creating account...": "Submit"}</button>
                </Styledform>
                <p>Already have an account? Login</p>
                </>
                )}
            </Styledmain>
            <Footer/>
        </>
    )
}
