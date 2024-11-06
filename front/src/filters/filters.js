
export function formatImaType(code) {
    let type = 'undefine';
    if (code === 'C') type = '规格组件';
    if (code === 'T') type = '最后规格料件';
    if (code === 'D') type = '特性料件';
    if (code === 'A') type = '族群料件';
    if (code === 'M') type = '自制料件';
    if (code === 'P') type = '采购料件';
    if (code === 'X') type = '虚拟料件';
    if (code === 'K') type = '配件虚拟料件';
    if (code === 'U') type = '自制大宗料件';
    if (code === 'V') type = '采购大宗料件';
    if (code === 'R') type = '在制途料件';
    if (code === 'Z') type = '杂项料件';
    if (code === 'S') type = '厂外加工料件';
    return code + ': ' + type;
}
