import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import styled from "styled-components";

const Page = styled.div`
  display: flex;
  height: 100vh;
  background: #e0f2fe;
`;

const Main = styled.div`
  flex: 1;
  display: flex;
  flex-direction: column;
  padding: 2rem;
  overflow: auto;
`;

const TopSection = styled.div`
  display: flex;
  gap: 1.5rem;
  margin-bottom: 2rem;
`;

const ChartContainer = styled.div`
  flex: 3;
  background: white;
  border-radius: .5rem;
  padding: 1rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
`;

const CategoriesContainer = styled.div`
  flex: 2;
  display: flex;
  flex-wrap: wrap;
  gap: .75rem;
  background: white;
  padding: 1rem;
  border-radius: .5rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
`;

const Chip = styled.div`
  display: inline-flex;
  align-items: center;
  background: #f3f4fe6;
  padding: .5rem .75rem;
  border-radius: 9999px;
  font-size: .875rem;
  position: relative;
  &:hover .delete {
    opacity: 1;
  }
`;

const Delete = styled.span`
  margin-left: .5rem;
  cursor: pointer;
  opacity: 0;
  transition: opacity .2s;
`;

const AddCategory = styled(Chip)`
  background: #d1fae5;
  color: #065f46;
  &::before {
    content: '+';
    margin-right: .5rem;
  }
`;

const TransactionList = styled.table`
  width: 100%;
  border-collapse: collapse;
  background: white;
  border-radius: .5rem;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
`;

const THead = styled.thead`
  background: #f9fafb;
`;

const TH = styled.th`
  text-align: left;
  padding: .75rem 1rem;
  font-size: .875rem;
  color: #374151;
`;

const TR = styled.tr`
  &:nth-child(even) { background: #f3f4f6; }
`;

const TD = styled.td`
  padding: .75rem 1rem;
  font-size: .875rem;
  color: #1f2937;
`;

const DeleteIcon = styled.span`
  color: #ef4444;
  cursor: pointer;
`;

const AddTxnButton = styled.button`
  margin-top: 1rem;
  padding: .75rem 1.5rem;
  background: #3b82f6;
  color: white;
  font-size: 1rem;
  border: none;
  border-radius: .5rem;
  cursor: pointer;
  align-self: flex-start;
`;

export default function TransactionsPage() {
  const data = {
    labels: ['Groceries','Rent','Utilities'],
    datasets: [{
      data: [250, 1200, 300],
      backgroundColor: ['#10b981','#ef4444','#f59e0b']
    }]
  };

  const categories = ['Groceries','Rent','Utilities'];
  const txns = [
    { date: '3/15', category: 'Groceries', amount: 24.50 },
    { date: '3/14', category: 'Rent',      amount: 950.00 },
    // …
  ];

  return (
    <>
      <Navbar/>
      <Page>
        <Sidebar/>
        <Main>
          <TopSection>
            <ChartContainer>
              {/* <Pie data={data} /> */}
            </ChartContainer>
            <CategoriesContainer>
              {categories.map(cat =>
                <Chip key={cat}>
                  {cat}
                  <Delete className="delete">×</Delete>
                </Chip>
              )}
              <AddCategory onClick={()=>{/* open modal */}}>
                Add Category
              </AddCategory>
            </CategoriesContainer>
          </TopSection>

          <TransactionList>
            <THead>
              <tr>
                <TH>Date</TH>
                <TH>Category</TH>
                <TH>Amount</TH>
                <TH>Delete</TH>
              </tr>
            </THead>
            <tbody>
              {txns.map((t,i) => (
                <TR key={i}>
                  <TD>{t.date}</TD>
                  <TD>{t.category}</TD>
                  <TD>${t.amount.toFixed(2)}</TD>
                  <TD><DeleteIcon onClick={()=>{/* delete */}}>×</DeleteIcon></TD>
                </TR>
              ))}
            </tbody>
          </TransactionList>

          <AddTxnButton onClick={()=>{/* open add‐txn modal */}}>
            + Add Transaction
          </AddTxnButton>
        </Main>
      </Page>
    </>
  );
}
