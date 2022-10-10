import React, {Component} from 'react';


//클래스형 컴포넌트 방식
class MynameClass extends Component {

    static defaultProps = {
        name : '클래스형'
    }

    render() {
        return (
            <div>
                안녕하세요 제 이름은 <b>{this.props.name}</b>입니다.
            </div>
        );
    }
}

export default MynameClass;
