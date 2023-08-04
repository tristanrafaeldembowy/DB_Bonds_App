import http from './axios-common';
import { getAllBonds } from '../services/bond-service'
export function getBonds(){
    return http.get("/bonds");
}

const [bonds,setBonds] = useState([]);

useEffect(()=>{
    getBondsFromAPI();}, 
    []
);
const getBondsFromAPI = ()=>{}

getAllBonds()
  .then(res => {
      setBonds(res.data);
  })
  .catch(err => {
      setBonds([]);
      console.log(err);
  })