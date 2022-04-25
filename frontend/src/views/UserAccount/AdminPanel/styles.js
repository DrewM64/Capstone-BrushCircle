const makeStyles = (
    value,
    index,
    isUserSelected,
    isSidebarOpen,
    isUserProductSelected,
    toggleInfoEdit,
    toggleProductEdit,
    user,) => {
    const userAccessRole = user.role;
    const adminPanelDisplay = value == index && userAccessRole === "ADMIN" ? "block" : "none";
    const searchContainerDisplay = isUserSelected ? "none" : "block";
    const selectionContainerDisplay = isUserSelected ? "flex" : "none";
    const sidebarDisplay = isSidebarOpen ? "block" : "none";
    const leftContainerWidth = isSidebarOpen ? "65%" : "100%";
    const sidebarRightValue = isSidebarOpen ? "0" : "-300px";
    const sidebarWidth = isSidebarOpen ? "35%" : "0px";
    const backButtonDisplay = toggleInfoEdit || toggleProductEdit ? "block" : "none";
    const editButtonDisplay = toggleInfoEdit || toggleProductEdit ? "none" : "block";
    const deleteButtonMargin = toggleInfoEdit || toggleProductEdit ? "auto" : "";
    const userInfoContainerDisplay = !isUserProductSelected && !toggleInfoEdit ? "grid" : "none";
    const userEditContainerDisplay = !isUserProductSelected && toggleInfoEdit ? "grid" : "none";
    const userProductViewContainerDisplay = isUserProductSelected && !toggleProductEdit ? "grid" : "none";
    const userProductEditContainerDisplay = isUserProductSelected && toggleProductEdit ? "grid" : "none";

    return {
        container: {
            display: adminPanelDisplay,
            width: "100%",
            height: "557px",
            '#searchHR': {
                color: 'lightgrey',
                margin: "10px 20px 10px 20px"
            }
        },
        searchContainer: {
            display: searchContainerDisplay,
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
        },
        tableRow: {
            cursor: 'cell',
            [':hover']: {
                backgroundColor: 'lightgrey'
            }
        },
        selectionContainer: {
            display: selectionContainerDisplay,
            height: "557px",
            overflow: "hidden",

        },
        leftInfoContainer: {
            width: leftContainerWidth,
            transition: "width 0.3s",
            padding: '10px 0 0 10px',
            ['#selectionHR']: {
                color: 'lightgrey',
                margin: "25px 20px 10px 0"
            }
        },
        rightSidebarContainer: {
            display: sidebarDisplay,
            position: "relative",
            right: sidebarRightValue,
            width: sidebarWidth,
            height: "100%",
            overflow: "auto",
            transition: "right 0.4s",
            borderLeft: "2px solid lightgrey",
        },
        mediaContainer: {
            display: "flex",
            maxHeight: "390px",
            flexWrap: "wrap",
            justifyContent: "center",
            columnGap: "20px",
            rowGap: "20px",
            padding: "30px",
            overflowY: "auto",
        },
        actionBar: {
            width: "100%",
            backgroundColor: "primary.main",
            button: {
                color: "white"
            }
        },
        editButton: {
            display: editButtonDisplay,
            marginLeft: "auto"
        },
        deleteButton: {
            marginLeft: deleteButtonMargin,
        },
        backButton: {
            display: backButtonDisplay,
        },
        userInfoContainer: {
            display: userInfoContainerDisplay,
            padding: "20px",
            rowGap: "5px",
            gridTemplateColumns: "auto auto",
        },
        userEditContainer: {
            display: userEditContainerDisplay,
            padding: "20px",
            rowGap: "16px",
        },
        userProductViewContainer: {
            display: userProductViewContainerDisplay,
            gridTemplateColumns: "100px auto",
            padding: "20px",
            rowGap: "10px",
        },
        userProductEditContainer: {
            display: userProductEditContainerDisplay,
            padding: "20px",
            rowGap: "16px",
        },
        imageContainer: {
            overflow: "hidden",
            height: "200px",
            gridColumn: "span 2",
            backgroundColor: "red",
            marginBottom: "10px",
            borderRadius: "6px",
            img: {
                width: "100%",
            }
        },
        descriptionLabel: {
            gridColumn: "span 2",
        },
        descriptionText: {
            gridColumn: "span 2",
            color: "gray",
            fontSize: "0.7em",
        },
        toggleSwitchContainer: {
            display: 'flex',
            justifyContent: 'end',
            alignItems: 'top'
        },
        biographyLabel: {
            gridColumn: "span 2",
        },
        biographyText: {
            gridColumn: "span  2",
            color: "gray",
            fontSize: "0.7em",
        },
        formGroup: {
            display: 'grid',
        },
        editToggleSwitchContainer: {
            display: 'flex',
            justifyContent: 'space-between'
        },
        toggleSwitchContainer: {
            display: 'flex',
            justifyContent: 'end',
            alignItems: 'top'
        },
        dimensionsContainer: {
            display: "grid",
            width: "65%",
            gridTemplateColumns: "auto auto",
            columnGap: "20px"
        },
        saveButton: {
            backgroundColor: "saveButtonColor",
            width: "50%",
            marginLeft: "auto",
            marginTop: "15px",
        },
        paymentMethodContainer: {
            display: "grid",
            gridTemplateColumns: "auto 80px",
            gridTemaplteRows: "auto auto",
        },
        paymentResetButton: {
            gridRow: "span 2",
            height: "25px",
        },
        resetBiographyButton: {
            height: "25px",
        },
        biographyContainer: {
            display: "grid",
            gridTemplateColumns: "auto 80px",
            rowGap: "10px",
        },
        userEditSaveButton: {
            backgroundColor: "saveButtonColor",
            marginLeft: "auto",
        },
        userEditSaveButtonContainer: {
            display: "flex",
        },
    }
}

export default makeStyles;