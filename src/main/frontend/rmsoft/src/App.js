import { BrowserRouter as Router, Route, Routes} from "react-router-dom";
import SignUpPage from "./pages/SignUp";
import MemberInfo from "./context/MemberContext";
import HomePage from "./pages/Home";
import BorrowPage from "./pages/Borrow";
import BookPage from "./pages/Book";
import NewBookPage from "./pages/BookNew";
import UpdateBookPage from "./pages/BookUpdate";
import UpdateBook from "./components/book/UpdateBook";
import BookHistoryPage from "./pages/BookHistory";
import BookHistory from "./components/book/BookHistory";
import BorrowSection from "./components/borrow/BorrowSection";
//import ;

function App() {
  return (
    <MemberInfo>
      <Router>
        <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/signUp' element={<SignUpPage />} />
          <Route path='/borrow' element={<BorrowPage />} />
          <Route path='/book' element={<BookPage />} />
          <Route path='/newBook' element={<NewBookPage />} />
          <Route path='/updateBook' element={<UpdateBookPage />} />
          <Route path='/update/:num' element={<UpdateBook />} />
          <Route path='/bookHistory' element={<BookHistoryPage />} />
          <Route path='/history/:num' element={<BookHistory />} />
          <Route path='/borrow/:num' element={<BorrowSection />} />




        </Routes>
      </Router>
    </MemberInfo>
  );
}

export default App;
