import axios from "axios";

const serverURL = "http://localhost:8000";
const API = axios.create({ baseURL: serverURL });

// authentication
export const register = (formData) => API.post('/user/register',formData);
export const login = (formData) => API.post('/user/login', formData);
export const update = (newUserObject) => API.post('user/update', newUserObject);
