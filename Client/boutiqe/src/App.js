
import './App.css';
import { Welcomepage } from './Welcomepage/welcomepage';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Menu } from './Menu';

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import { Signuppage } from './Signuppage/signuppage';
import { Loginpage } from './Components/Loginpage/loginpage';
import { Desuppage } from './Components/Loginpage/Designeruploadpage/despagenav';
import { Desworkpage } from './Components/Loginpage/Designeruploadpage/desuppage';
import { Desupdasbord } from './Components/Loginpage/Designeruploadpage/desupdasbord';
import { Desprofile } from './Components/Loginpage/Designeruploadpage/desprofile';
import { Desprofileview } from './Components/Loginpage/Designeruploadpage/desprofileview';
import { Cusdesboard } from './Components/Cuspage/cusdesboard';
import { Cusviewpage } from './Components/Cuspage/cusveiwpage';
import { Getoneproduct } from './Components/Cuspage/getonedesigner';
import { Desupdatepage } from './Components/Loginpage/Designeruploadpage/desupdatepage';
import { Desprofileupdate } from './Components/Loginpage/Designeruploadpage/desprofileupdate';
import { Customerform } from './Components/Cuspage/cusform';
import { Vieworder } from './Components/Cuspage/vieworder';
function App() {
  return (
     <>
     <BrowserRouter>
     <Routes>
      <Route path='/' element={[<Welcomepage/>]}/>
      <Route path='/Registration' element={[< Signuppage/>]}/>
      
      <Route path='/login' element={[<Loginpage/>]}/>
      <Route path='/Signuppage'element={[<Signuppage/>]}/>
      <Route path='/desuppage/:s_no'element={[<Desuppage/>,<Desupdasbord/> ]}/>
      <Route path='desuploadpage/:s_no' element={[<Desworkpage/>]}/>
      <Route path='/desviewpage/:s_no' element={[<Desuppage/>,<Desupdasbord/>]}/>
      <Route path='/edityourworks/:s_no' element={[<Desupdatepage/>]}/>
      <Route path='/editprofile/:s_no' element={[<Desprofile/>]}/>
      <Route path='/desnav' element={[<Desuppage/>]}/>
      <Route path='/desproview/:s_no' element={[<Desprofileview/>]}/>
      <Route path='/getonedesigner/:s_no' element={[<Getoneproduct/>]}/>
      <Route path='/cusviewpage/:s_no' element={[<Cusdesboard/>,<Cusviewpage/>]}/>
      <Route path='/desedit/:s_no' element={[<Desprofileupdate/>]}/>
      <Route path='/desprofileview/:s_no' element={[<Desprofileview/>]}/>
      <Route path='/cusform/:s_no' element={[<Customerform/>]}/>
      <Route path='/vieworder/:s_no' element={[<Vieworder/>]}/>
   
    




      
      




      


     </Routes>
     </BrowserRouter>
     </>
  );
}

export default App;
