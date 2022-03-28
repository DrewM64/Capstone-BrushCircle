import { borderRadius, height } from "@mui/system";

const styles = {
    content: {
        width: "70%",
        height: "100%",
        overflowY: "scroll",
        transition: "width 0.3s",
    },
    contentExpanded: {
        overflowY: "scroll",
        width: "100%",
        height: "100%",
        transition: "width 0.3s",
    },
    rightSidebar: {
        position: "relative",
        right: "0",
        width: "30%",
        height: "100%",
        transition: "right 0.4s",
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
        gridTemplateColumns: "auto auto",
        rowGap: "5px",
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
        rowGap: "5px"
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
    }
}

export default styles;