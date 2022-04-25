import { borderRadius, height } from "@mui/system";

const styles = {
    content: {
        width: "70%",
        height: "100%",
        overflowY: "auto",
        transition: "width 0.3s",
    },
    contentExpanded: {
        overflowY: "auto",
        width: "100%",
        height: "100%",
        transition: "width 0.3s",
    },
    rightSidebar: {
        position: "relative",
        right: "0",
        width: "40%",
        height: "100%",
        transition: "right 0.4s",
        borderLeft: "2px solid lightgrey",
        overflow: "auto",
    },
    rightSidebarClosed: {
        position: "relative",
        right: "-300px",
        width: "0px",
        height: "100%",
    },
    imagesList: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent: "center",
        columnGap: "20px",
        rowGap: "20px",
        padding: "30px",
    },
    uploadButton: {
        margin: "20px 0 20px 0"
    },
    actionBar: {
        width: "100%",
        backgroundColor: "primary.main",
    },
    actionButton: {
        color: "white"
    },
    backActionButton: {
        color: "white",
    },
    sidebarInfoContainer: {
        display: "grid",
        padding: "20px",
        gridTemplateColumns: "100px auto",
        rowGap: "10px",
    },
    sidebarInfoContainerHidden: {
        display: "none",
        padding: "20px",
        gridTemplateColumns: "auto auto",
        rowGap: "5px",
    },
    imageContainer: {
        overflow: "hidden",
        height: "200px",
        gridColumn: "span 2",
        marginBottom: "10px",
        borderRadius: "6px",
        img: {
            width: "100%",
        }
    },
    sidebarFormContainer: {
        display: "grid",
        padding: "20px",
        rowGap: "16px"
    },
    sidebarFormContainerHidden: {
        display: "none"
    },
    rightActionButton: {
        marginLeft: "auto",
        color: "white",
    },
    rightActionButtonHidden: {
        display: "none"
    },
    saveButton: {
        backgroundColor: "saveButtonColor",
        width: "50%",
        marginLeft: "auto",
        marginTop: "15px",
    },
    toggleSwitchContainer: {
        display: 'flex',
        justifyContent: 'end',
        alignItems: 'top'
    },
    editToggleSwitchContainer: {
        display: 'flex',
        justifyContent: 'space-between'
    },
    toggleSwitch: {

    },
    descriptionLabel: {
        gridColumn: "span 2",
    },
    descriptionText: {
        gridColumn: "span 2",
        color: "gray",
        fontSize: "0.7em"
    },
    priceTextField: {
        width: '40%'
    },
    dimensionsContainer: {
        display: "grid",
        width: "65%",
        gridTemplateColumns: "auto auto",
        columnGap: "20px"
    },
    formGroup: {
        display: 'grid',
    }
}

export default styles;