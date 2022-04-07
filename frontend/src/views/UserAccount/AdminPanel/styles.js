const makeStyles = (value, index) => {
    const adminPanelDisplay = value == index ? "block" : "none";
    return {
        container: {
            display: adminPanelDisplay,
            width: "100%",
            height: "557px",
            hr: {
                color: 'lightgrey',
                margin: "10px 20px 10px 20px"
            }
        },
        adminHeader: {
            display: "flex",
            columnGap: "20px",
            width: "600px",
            padding: "40px 0 20px 20px",
        },
        addUserButton: {
            backgroundColor: "saveButtonColor",
        },
        searchField: {
            flexGrow: "1",
        },
        resultsContainer: {
            maxHeight: "420px",
            padding: "0 20px 0 20px",
            overflow: "auto",
        }
    }
}

export default makeStyles;