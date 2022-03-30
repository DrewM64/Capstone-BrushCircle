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
        backgroundColor: "cancelButtonColor",
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
    },
    saveButton: {
        backgroundColor: "saveButtonColor",
    },
    profileImageContainer: {
        width: "124px",
        height: "124px",
        gridArea: "image",
        overflow: "hidden"
    }
}

export default styles;