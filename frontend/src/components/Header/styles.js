const makeStyles = (user) => {
    const signupButtonDisplay = user ? "none" : "block";
    const loginButtonDisaply = user ? "none" : "block";

    const styles = {
        container: {
            marginBottom: "",
            flexGrow: 1,
        },
        toolbar: {
            img: {
                height: "30px"
            }
        },
        searchInput: {
            margin: "auto",
        },
        profileButton: {
            overflow: "hidden",
            img: {
                borderRadius: "50%",
                height: "25px",
                width: "25px"
            }
        },
        loginButton: {
            display: loginButtonDisaply,
        },
        signupButton: {
            display: signupButtonDisplay,
        },
    }

    return styles;
}

export default makeStyles;