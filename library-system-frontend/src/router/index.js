import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePage from "../page/HomePage";
import Introduction from "../components/homePage/Introduction";
import Location from "../components/homePage/Location";
import AboutBooks from "../components/homePage/AboutBooks";
import ContactUs from "../components/homePage/ContactUs";
import QueryPage from "../page/QueryPage";
import SingleQuery from "../components/queryBook/SingleQuery";
import AdvanceContent from "../components/queryBook/AdvanceContent";
import BorrowPage from "../page/BorrowPage";
import BorrowBook from "../components/BorrowPage/BorrowBook";
import ReturnBook from "../components/BorrowPage/ReturnBook";
import AdminPage from "../page/AdminPage";
import UserRegister from "../components/AdminPage/UserRegister";
import BookDashboard from "../components/AdminPage/book/BookDashboard";
import InputBook from "../components/AdminPage/book/InputBook";
import BookQuery from "../components/AdminPage/book/BookQuery";
import UserDashboard from "../components/AdminPage/user/UserDashboard";
import Blocklist from "../components/AdminPage/user/Blocklist";
import UserQuery from "../components/AdminPage/user/UserQuery";
import ResultPage from "../components/queryBook/ResultPage";
import BookResult from "../components/AdminPage/book/BookResult";
import UserResult from "../components/AdminPage/user/UserResult";
import BorrowResult from "../components/AdminPage/borrow/BorrowResult";
import BorrowQuery from "../components/AdminPage/borrow/BorrowQuery";

Vue.use(VueRouter)
const routes = [
    {
        path: '/',
        component: HomePage,
        children: [
            {path: '', component: Introduction},
            {path: 'location', component: Location},
            {path: 'about-books', component: AboutBooks},
            {path: 'contact-us', component: ContactUs}
        ]
    }, {
        path: '/query',
        component: QueryPage,
        children: [
            {path: '', component: SingleQuery},
            {path: 'advance', component: AdvanceContent},
            {path: '/result', component: ResultPage}
        ]
    },
    {
        path: '/borrow', component: BorrowPage,
        children: [
            {path: '', component: BorrowBook},
            {path: 'return', component: ReturnBook}
        ]
    }, {
        path: '/admin', component: AdminPage,
        children: [
            {path: '', component: UserRegister},
            {path: 'book', component: BookDashboard},
            {path: 'book/input', component: InputBook},
            {path: 'book/query', component: BookQuery},
            {path: 'book/result', component: BookResult},
            {path: 'user', component: UserDashboard},
            {path: 'user/blocklist', component: Blocklist},
            {path: 'user/query', component: UserQuery},
            {path: 'user/result', component: UserResult},
            {path: 'borrow', component: BorrowResult},
            {path:'borrow/query',component:BorrowQuery},
            {path:'borrow/result',component:BorrowResult}
        ]
    }
]
export default new VueRouter({
        routes
    }
)