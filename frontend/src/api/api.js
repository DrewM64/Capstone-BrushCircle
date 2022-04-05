import axios from "axios";

const serverURL = "http://localhost:8080";
const API = axios.create({ baseURL: serverURL });

// authentication
export const register = (formData) => API.post('/user/register',formData);
