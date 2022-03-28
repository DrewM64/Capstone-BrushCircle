const styles = {
    container: {
        padding: '20px'
    },
    accountHeader: {
        display: "grid",
        marginBottom: "20px",
        width: "330px",
        gridTemplateColumns: "auto 180px",
        gridTemplateAreas: "'headerLabel headerLabel' 'image uploadButton' 'image resetButton' 'image subtitle'",
        columnGap: "10px",
        rowGap: "10px",
    },
    profileTitle: {
        gridArea: "headerLabel"
    },
    uploadButton: {
        gridArea: "uploadButton",
    },
    resetbutton: {
        gridArea: "resetButton",
        width: "",
    },
    subtitle: {
        gridArea: "subtitle",
        fontSize: "0.7em",
    },
    formContainer: {
        display: "grid",
        marginTop: "30px",
        marginBottom: "30px",
        columnGap: "40px",
        rowGap: "40px",
        gridTemplateColumns: "300px 300px 300px",
    },
    buttonContainer: {
        display: "flex",
        columnGap: "20px"
    }
}

export default styles;