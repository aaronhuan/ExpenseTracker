import Navbar from "../components/Navbar";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import Footer from "../components/Footer";

const StyledBody = styled.main`
  display: flex;
  background: lightblue;
  height: 100vh;
`;

const ContentWrapper = styled.div`
  display: flex;
  flex-direction: column;
  flex: 1;             /* take all the space beside sidebar */
  gap: 1rem;
`;

const Content = styled.div`
  display: flex;
  flex: 1;             /* fill up available vertical space above footer */
  gap: 1rem;
`;

const GraphContainer = styled.div`
  flex: 5; 
  background: white;
  border: 1px solid black;
  border-radius: 0.5rem;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 300px;   /* tweak this to taste */
`;

const WidgetColumn = styled.div`
  flex: 4;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
`;

const Widget = styled.div`
  background-color: white;
  padding: 1.5rem;
  border-radius: 0.75rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
  border-left: 6px solid ${(p) => p.color || "#64748b"};
  min-height: 120px;   /* make them a bit taller */
  display: flex;
  align-items: center;
  justify-content: center;
`;

const TransContainer = styled.div`
  display:flex;
`;

export default function Expenses() {
  return (
    <>
      <Navbar />
      <StyledBody>
        <Sidebar />
        <ContentWrapper>
          <Content>
            <GraphContainer>
              <p>graph</p>
            </GraphContainer>

            <WidgetColumn>
                <div>
                    <p>income</p>
                    <Widget color="green">$123</Widget>
                </div>
                <div>
                    <p>Expenses</p>
                    <Widget color="red">$111</Widget>
                </div>
                <div>
                    <p>Balance</p>
                    <Widget color="blue">$income - expenses</Widget>
                </div>
            </WidgetColumn>
          </Content>

          <TransContainer>
            <Widget style={{ flex: 2 }}>add txn</Widget>
            <Widget style={{ flex: 3 }}>recent txn</Widget>
          </TransContainer>
        </ContentWrapper>
      </StyledBody>
      <Footer/>
    </>
  );
}